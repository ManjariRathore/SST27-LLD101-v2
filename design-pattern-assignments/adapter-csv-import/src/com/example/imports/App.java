
package com.example.imports;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // if (args.length == 0) throw new IllegalArgumentException("path required");
        // Path csv = Path.of(args[0]);
        Path csv = Files.createTempFile("users", ".csv");
        List<String> lines = Arrays.asList(
            "id,email,displayName",
            "1,alice@example.com,Alice",
            "2,,Bob",                        // missing email
            "3,bobexample.com,Bob",          // bad email
            "4,charlie@example.com,Charlie"  // valid
        );
        Files.write(csv, lines);
        ProfileImporter importer = new CSVProfileImporter(new NaiveCsvReader(), new ProfileService());
        int n = importer.importFrom(csv);
        System.out.println("Imported " + n + " profiles");
        System.out.println("Import OK (wire the adapter to complete).");
    }
}