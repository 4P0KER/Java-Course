import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Усовершенствованный узел дерева Хаффмана.
 * Добавлены вспомогательные методы для сериализации/десериализации.
 */
class EnhancedHuffmanNode implements Comparable<EnhancedHuffmanNode> {
    final byte symbol;
    final int frequency;
    EnhancedHuffmanNode left, right;

    EnhancedHuffmanNode(byte symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    EnhancedHuffmanNode(EnhancedHuffmanNode left, EnhancedHuffmanNode right) {
        this.symbol = -1;
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(EnhancedHuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }

    // Новый метод: компактная сериализация узла
    void serialize(DataOutputStream dos) throws IOException {
        dos.writeBoolean(isLeaf());
        if (isLeaf()) {
            dos.writeByte(symbol);
            dos.writeInt(frequency);
        }
    }

    // Новый метод: компактная десериализация
    static EnhancedHuffmanNode deserialize(DataInputStream dis) throws IOException {
        boolean isLeaf = dis.readBoolean();
        if (isLeaf) {
            return new EnhancedHuffmanNode(dis.readByte(), dis.readInt());
        } else {
            // Для внутренних узлов нужно построить дерево рекурсивно
            return null; // Обрабатывается отдельно при построении дерева
        }
    }
}

/**
 * Улучшенный кодер Хаффмана с оптимизациями из обоих подходов.
 */
class ImprovedHuffmanCoder {
    private static final String COMPRESSED_EXTENSION = ".huff";
    private static final String DECODED_SUFFIX = "_decoded";

    // Основной метод кодирования с улучшенной обработкой
    public static void compress(String inputPath, String outputPath) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get(inputPath));

        // Проверка на пустой файл (идея из вашего кода)
        if (data.length == 0) {
            System.out.println("Файл пустой, сжатие не требуется");
            Files.write(Paths.get(outputPath), new byte[0]);
            return;
        }

        // Построение частотной таблицы с оптимизацией для малых файлов
        FrequencyTable freqTable = buildOptimizedFrequencyTable(data);

        // Построение дерева с использованием приоритетной очереди
        EnhancedHuffmanNode root = buildHuffmanTree(freqTable);

        // Генерация кодов с автоматической проверкой на один символ
        CodeTable codeTable = generateCodes(root);

        // Кодирование данных
        EncodedResult encoded = encodeData(data, codeTable);

        // Валидация кодирования (идея из вашего кода)
        validateEncoding(data, encoded.bitString, root);

        // Сохранение в компактном формате
        saveCompressedFile(outputPath, freqTable, encoded, getOriginalExtension(inputPath));

        // Вывод подробной статистики (улучшенная версия)
        printCompressionStats(inputPath, outputPath, data.length, encoded, freqTable);
    }

    // Метод декодирования с автоматическим определением формата
    public static void decompress(String inputPath, String outputPath) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(inputPath))) {

            // Определение формата файла (простой/оптимизированный)
            FileFormat format = detectFileFormat(dis);

            // Чтение метаданных в зависимости от формата
            CompressionMetadata metadata = readMetadata(dis, format);

            // Восстановление дерева Хаффмана
            EnhancedHuffmanNode root = rebuildTree(metadata.frequencies);

            // Декодирование данных
            byte[] decodedData = decodeStream(dis, root, metadata);

            // Восстановление оригинального имени файла
            String finalOutputPath = determineOutputPath(inputPath, outputPath, metadata.originalExtension);

            // Сохранение декодированных данных
            Files.write(Paths.get(finalOutputPath), decodedData);

            System.out.println("Декодирование завершено успешно!");
            System.out.println("Восстановленный файл: " + finalOutputPath);
            System.out.println("Размер: " + decodedData.length + " байт");
        }
    }

    // Вспомогательные классы для лучшей организации данных
    private static class FrequencyTable {
        final Map<Byte, Integer> frequencies;
        final int uniqueSymbols;

        FrequencyTable(Map<Byte, Integer> frequencies) {
            this.frequencies = frequencies;
            this.uniqueSymbols = frequencies.size();
        }

        // Быстрое построение таблицы с предварительным распределением
        static FrequencyTable build(byte[] data) {
            if (data.length < 1024) {
                // Для маленьких файлов используем простой подход
                return buildSimple(data);
            } else {
                // Для больших файлов используем оптимизированный подход
                return buildOptimized(data);
            }
        }

        private static FrequencyTable buildSimple(byte[] data) {
            Map<Byte, Integer> map = new HashMap<>();
            for (byte b : data) {
                map.put(b, map.getOrDefault(b, 0) + 1);
            }
            return new FrequencyTable(map);
        }

        private static FrequencyTable buildOptimized(byte[] data) {
            // Используем массив для подсчета частот (быстрее для бинарных файлов)
            int[] freqArray = new int[256];
            for (byte b : data) {
                freqArray[b & 0xFF]++;
            }

            Map<Byte, Integer> map = new HashMap<>();
            for (int i = 0; i < 256; i++) {
                if (freqArray[i] > 0) {
                    map.put((byte) i, freqArray[i]);
                }
            }
            return new FrequencyTable(map);
        }
    }

    private static class CodeTable {
        final Map<Byte, String> encodeMap;
        final Map<String, Byte> decodeMap;
        final int maxCodeLength;

        CodeTable(Map<Byte, String> encodeMap) {
            this.encodeMap = encodeMap;
            this.decodeMap = new HashMap<>();
            int maxLen = 0;

            for (Map.Entry<Byte, String> entry : encodeMap.entrySet()) {
                String code = entry.getValue();
                decodeMap.put(code, entry.getKey());
                maxLen = Math.max(maxLen, code.length());
            }
            this.maxCodeLength = maxLen;
        }
    }

    private static class EncodedResult {
        final String bitString;
        final byte[] packedBytes;
        final int originalBitLength;

        EncodedResult(String bitString) {
            this.bitString = bitString;
            this.originalBitLength = bitString.length();
            this.packedBytes = packBits(bitString);
        }

        private static byte[] packBits(String bits) {
            int byteCount = (bits.length() + 7) / 8;
            byte[] result = new byte[byteCount];

            for (int i = 0; i < bits.length(); i++) {
                if (bits.charAt(i) == '1') {
                    result[i / 8] |= (1 << (7 - (i % 8)));
                }
            }
            return result;
        }
    }

    private static class CompressionMetadata {
        final Map<Byte, Integer> frequencies;
        final String originalExtension;
        final int originalSize;
        final int encodedBitLength;

        CompressionMetadata(Map<Byte, Integer> frequencies, String extension,
                            int originalSize, int bitLength) {
            this.frequencies = frequencies;
            this.originalExtension = extension;
            this.originalSize = originalSize;
            this.encodedBitLength = bitLength;
        }
    }

    private enum FileFormat {
        SIMPLE,      // Простой формат: частота + данные
        OPTIMIZED,   // Оптимизированный формат с флагами
        SINGLE_CHAR  // Специальный формат для одного символа
    }

    // Основные алгоритмические методы

    private static EnhancedHuffmanNode buildHuffmanTree(FrequencyTable freqTable) {
        if (freqTable.uniqueSymbols == 1) {
            // Особый случай: один символ
            Map.Entry<Byte, Integer> entry = freqTable.frequencies.entrySet().iterator().next();
            return new EnhancedHuffmanNode(entry.getKey(), entry.getValue());
        }

        PriorityQueue<EnhancedHuffmanNode> pq = new PriorityQueue<>();

        for (Map.Entry<Byte, Integer> entry : freqTable.frequencies.entrySet()) {
            pq.offer(new EnhancedHuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            EnhancedHuffmanNode left = pq.poll();
            EnhancedHuffmanNode right = pq.poll();
            pq.offer(new EnhancedHuffmanNode(left, right));
        }

        return pq.poll();
    }

    private static CodeTable generateCodes(EnhancedHuffmanNode root) {
        Map<Byte, String> codes = new HashMap<>();

        if (root.isLeaf()) {
            // Для одного символа используем код "0"
            codes.put(root.symbol, "0");
        } else {
            generateCodesRecursive(root, "", codes);
        }

        return new CodeTable(codes);
    }

    private static void generateCodesRecursive(EnhancedHuffmanNode node, String code,
                                               Map<Byte, String> codes) {
        if (node.isLeaf()) {
            // Сохраняем код только для листьев
            codes.put(node.symbol, code.isEmpty() ? "0" : code);
        } else {
            generateCodesRecursive(node.left, code + "0", codes);
            generateCodesRecursive(node.right, code + "1", codes);
        }
    }

    private static EncodedResult encodeData(byte[] data, CodeTable codeTable) {
        StringBuilder bits = new StringBuilder();

        // Быстрое кодирование с предварительным выделением памяти
        int estimatedSize = data.length * codeTable.maxCodeLength;
        bits.ensureCapacity(estimatedSize);

        for (byte b : data) {
            bits.append(codeTable.encodeMap.get(b));
        }

        return new EncodedResult(bits.toString());
    }

    private static void validateEncoding(byte[] original, String encodedBits,
                                         EnhancedHuffmanNode root) {
        try {
            byte[] test = decodeBits(encodedBits, root, original.length);
            if (!Arrays.equals(original, test)) {
                System.err.println("Предупреждение: тест кодирования/декодирования не прошел!");
            }
        } catch (Exception e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }
    }

    // Улучшенное сохранение с автоматическим выбором формата
    private static void saveCompressedFile(String path, FrequencyTable freqTable,
                                           EncodedResult encoded, String originalExtension)
            throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {

            // Выбор оптимального формата
            if (freqTable.uniqueSymbols == 1) {
                saveSingleCharFormat(dos, freqTable, encoded);
            } else if (freqTable.uniqueSymbols <= 255 && encoded.originalBitLength < 65536) {
                saveCompactFormat(dos, freqTable, encoded, originalExtension);
            } else {
                saveStandardFormat(dos, freqTable, encoded);
            }
        }
    }

    private static void saveSingleCharFormat(DataOutputStream dos, FrequencyTable freqTable,
                                             EncodedResult encoded) throws IOException {
        // Специальный формат для одного символа
        dos.writeByte(0xFF); // Маркер специального формата

        Map.Entry<Byte, Integer> entry = freqTable.frequencies.entrySet().iterator().next();
        dos.writeByte(entry.getKey());      // Символ
        dos.writeInt(entry.getValue());     // Количество повторений
    }

    private static void saveCompactFormat(DataOutputStream dos, FrequencyTable freqTable,
                                          EncodedResult encoded, String originalExtension)
            throws IOException {
        // Компактный формат с минимальным оверхедом
        dos.writeByte(0x01); // Маркер компактного формата

        // Сохраняем таблицу частот
        dos.writeByte(freqTable.uniqueSymbols);
        for (Map.Entry<Byte, Integer> entry : freqTable.frequencies.entrySet()) {
            dos.writeByte(entry.getKey());
            dos.writeShort(entry.getValue()); // Частота как short (до 65535)
        }

        // Сохраняем данные
        dos.writeShort(encoded.originalBitLength);
        dos.write(encoded.packedBytes);

        // Сохраняем расширение, если есть
        if (!originalExtension.isEmpty()) {
            dos.writeByte(originalExtension.length());
            dos.writeBytes(originalExtension.substring(1));
        }
    }

    private static void saveStandardFormat(DataOutputStream dos, FrequencyTable freqTable,
                                           EncodedResult encoded) throws IOException {
        // Стандартный формат для больших файлов
        dos.writeInt(freqTable.uniqueSymbols);

        for (Map.Entry<Byte, Integer> entry : freqTable.frequencies.entrySet()) {
            dos.writeByte(entry.getKey());
            dos.writeInt(entry.getValue());
        }

        dos.writeInt(encoded.originalBitLength);
        dos.write(encoded.packedBytes);
    }

    // Восстановление дерева из частотной таблицы
    private static EnhancedHuffmanNode rebuildTree(Map<Byte, Integer> frequencies) {
        return buildHuffmanTree(new FrequencyTable(frequencies));
    }

    // Улучшенное декодирование с потоковой обработкой
    private static byte[] decodeStream(DataInputStream dis, EnhancedHuffmanNode root,
                                       CompressionMetadata metadata) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        EnhancedHuffmanNode current = root;

        // Специальная обработка для одного символа
        if (root.isLeaf()) {
            for (int i = 0; i < metadata.originalSize; i++) {
                baos.write(root.symbol);
            }
            return baos.toByteArray();
        }

        // Чтение и декодирование битового потока
        int bitsRead = 0;
        while (bitsRead < metadata.encodedBitLength) {
            int b = dis.readByte() & 0xFF;

            for (int i = 7; i >= 0 && bitsRead < metadata.encodedBitLength; i--) {
                int bit = (b >> i) & 1;
                current = (bit == 0) ? current.left : current.right;

                if (current.isLeaf()) {
                    baos.write(current.symbol);
                    current = root;
                }
                bitsRead++;
            }
        }

        return baos.toByteArray();
    }

    // Вспомогательные методы

    private static FrequencyTable buildOptimizedFrequencyTable(byte[] data) {
        return FrequencyTable.build(data);
    }

    private static byte[] decodeBits(String bits, EnhancedHuffmanNode root, int expectedLength) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        EnhancedHuffmanNode current = root;
        int decoded = 0;

        for (int i = 0; i < bits.length() && decoded < expectedLength; i++) {
            current = (bits.charAt(i) == '0') ? current.left : current.right;

            if (current.isLeaf()) {
                baos.write(current.symbol);
                current = root;
                decoded++;
            }
        }

        return baos.toByteArray();
    }

    private static String getOriginalExtension(String path) {
        int dotIndex = path.lastIndexOf('.');
        return (dotIndex > 0) ? path.substring(dotIndex) : "";
    }

    private static FileFormat detectFileFormat(DataInputStream dis) throws IOException {
        dis.mark(1);
        byte firstByte = dis.readByte();
        dis.reset();

        if (firstByte == (byte) 0xFF) return FileFormat.SINGLE_CHAR;
        if (firstByte == 0x01) return FileFormat.OPTIMIZED;
        return FileFormat.SIMPLE;
    }

    private static CompressionMetadata readMetadata(DataInputStream dis, FileFormat format)
            throws IOException {
        switch (format) {
            case SINGLE_CHAR:
                dis.readByte(); // Пропускаем маркер
                byte symbol = dis.readByte();
                int count = dis.readInt();
                Map<Byte, Integer> freq = new HashMap<>();
                freq.put(symbol, count);
                return new CompressionMetadata(freq, "", count, 0);

            case OPTIMIZED:
                return readCompactMetadata(dis);

            default:
                return readStandardMetadata(dis);
        }
    }

    private static CompressionMetadata readCompactMetadata(DataInputStream dis)
            throws IOException {
        dis.readByte(); // Пропускаем маркер

        int symbolCount = dis.readByte() & 0xFF;
        Map<Byte, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < symbolCount; i++) {
            byte symbol = dis.readByte();
            int freq = dis.readShort() & 0xFFFF;
            frequencies.put(symbol, freq);
        }

        int bitLength = dis.readShort() & 0xFFFF;

        // Читаем расширение, если есть
        String extension = "";
        if (dis.available() > 0) {
            int extLen = dis.readByte() & 0xFF;
            if (extLen > 0) {
                byte[] extBytes = new byte[extLen];
                dis.readFully(extBytes);
                extension = "." + new String(extBytes);
            }
        }

        return new CompressionMetadata(frequencies, extension,
                calculateOriginalSize(frequencies), bitLength);
    }

    private static CompressionMetadata readStandardMetadata(DataInputStream dis)
            throws IOException {
        int symbolCount = dis.readInt();
        Map<Byte, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < symbolCount; i++) {
            byte symbol = dis.readByte();
            int freq = dis.readInt();
            frequencies.put(symbol, freq);
        }

        int bitLength = dis.readInt();
        return new CompressionMetadata(frequencies, "",
                calculateOriginalSize(frequencies), bitLength);
    }

    private static int calculateOriginalSize(Map<Byte, Integer> frequencies) {
        return frequencies.values().stream().mapToInt(Integer::intValue).sum();
    }

    private static String determineOutputPath(String inputPath, String outputPath,
                                              String originalExtension) {
        if (outputPath != null && !outputPath.isEmpty()) {
            return outputPath;
        }

        // Автоматическое определение имени
        String baseName = inputPath.replaceAll("\\.huff$", "");
        if (baseName.equals(inputPath)) {
            baseName = inputPath + DECODED_SUFFIX;
        }

        return baseName + originalExtension;
    }

    // Улучшенный вывод статистики
    private static void printCompressionStats(String inputPath, String outputPath,
                                              int originalSize, EncodedResult encoded,
                                              FrequencyTable freqTable) throws IOException {
        File compressedFile = new File(outputPath);
        long compressedSize = compressedFile.length();

        double compressionRatio = (1.0 - (double) compressedSize / originalSize) * 100;
        double bitRate = (encoded.originalBitLength * 100.0) / originalSize;

        System.out.println("\n=== Результаты сжатия ===");
        System.out.printf("Исходный файл:     %s\n", inputPath);
        System.out.printf("Сжатый файл:       %s\n", outputPath);
        System.out.printf("Исходный размер:   %,d байт\n", originalSize);
        System.out.printf("Сжатый размер:     %,d байт\n", compressedSize);
        System.out.printf("Коэффициент сжатия: %.2f%%\n", compressionRatio);
        System.out.printf("Битовая скорость:   %.1f%%\n", bitRate);
        System.out.printf("Уникальных символов: %d\n", freqTable.uniqueSymbols);

        if (freqTable.uniqueSymbols <= 15) {
            System.out.println("\nТаблица частот:");
            freqTable.frequencies.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(e -> System.out.printf("  %s: %d (%.1f%%)\n",
                            formatByte(e.getKey()), e.getValue(),
                            e.getValue() * 100.0 / originalSize));
        }
    }

    private static String formatByte(byte b) {
        int val = b & 0xFF;
        if (val >= 32 && val <= 126) {
            char c = (char) val;
            if (c == '\\') return "'\\\\'";
            if (c == '\'') return "'\\''";
            return "'" + c + "'";
        }
        return String.format("0x%02X", val);
    }

    // Главный метод с улучшенным интерфейсом
    public static void main(String[] args) {
        if (args.length < 2) {
            printHelp();
            return;
        }

        String command = args[0].toLowerCase();

        try {
            switch (command) {
                case "compress":
                case "c":
                    handleCompress(args);
                    break;

                case "decompress":
                case "d":
                    handleDecompress(args);
                    break;

                case "info":
                    showFileInfo(args);
                    break;

                default:
                    System.err.println("Неизвестная команда: " + command);
                    printHelp();
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleCompress(String[] args) throws IOException {
        String inputFile = args[1];
        String outputFile = (args.length > 2) ? args[2] :
                inputFile.replaceAll("\\.[^.]*$", "") + COMPRESSED_EXTENSION;

        System.out.println("Сжатие файла: " + inputFile);
        compress(inputFile, outputFile);
    }

    private static void handleDecompress(String[] args) throws IOException {
        String inputFile = args[1];
        String outputFile = (args.length > 2) ? args[2] : null;

        System.out.println("Распаковка файла: " + inputFile);
        decompress(inputFile, outputFile);
    }

    private static void showFileInfo(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Укажите файл для анализа");
            return;
        }

        String file = args[1];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            FileFormat format = detectFileFormat(dis);
            System.out.println("Формат файла: " + format);

            CompressionMetadata meta = readMetadata(dis, format);
            System.out.println("Уникальных символов: " + meta.frequencies.size());
            System.out.println("Оригинальный размер: " + meta.originalSize + " байт");

            if (!meta.originalExtension.isEmpty()) {
                System.out.println("Оригинальное расширение: " + meta.originalExtension);
            }
        }
    }

    private static void printHelp() {
        System.out.println("Усовершенствованный кодер Хаффмана");
        System.out.println("\nИспользование:");
        System.out.println("  Сжатие:    java ImprovedHuffmanCoder compress <входной> [выходной]");
        System.out.println("             java ImprovedHuffmanCoder c <входной> [выходной]");
        System.out.println("  Распаковка: java ImprovedHuffmanCoder decompress <входной> [выходной]");
        System.out.println("             java ImprovedHuffmanCoder d <входной> [выходной]");
        System.out.println("  Информация: java ImprovedHuffmanCoder info <файл.huff>");
        System.out.println("\nПримеры:");
        System.out.println("  java ImprovedHuffmanCoder c input.txt");
        System.out.println("  java ImprovedHuffmanCoder d input.huff output.txt");
        System.out.println("  java ImprovedHuffmanCoder info compressed.huff");
        System.out.println("\nАвтоматические имена:");
        System.out.println("  При сжатии:    original.txt → original.huff");
        System.out.println("  При распаковке: original.huff → original_decoded.txt");
    }
}