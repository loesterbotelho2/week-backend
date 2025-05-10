package com.nexuscare.recipe.config;

import io.github.cdimascio.dotenv.Dotenv;

public class AppConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static final String DB_URL = dotenv.get("DATABASE_URL");
    public static final String DB_USER = dotenv.get("DATABASE_USER");
    public static final String DB_PASSWORD = dotenv.get("DATABASE_PASSWORD");
}
