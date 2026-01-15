package com.brightertorches;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * BrighterTorches Plugin - Makes torches emit brighter light in Hytale
 *
 * This plugin increases the light level emitted by torches to improve
 * visibility in caves and dark areas. Light levels can be configured
 * in the config.json file.
 *
 * @author Claude
 * @version 1.0.0
 */
public class BrighterTorchesPlugin {

    private static BrighterTorchesPlugin instance;
    private BrighterTorchesConfig config;

    /**
     * Constructor - Called when plugin is loaded.
     */
    public BrighterTorchesPlugin() {
        instance = this;
        System.out.println("[BrighterTorches] Plugin loaded!");
    }

    /**
     * Called when plugin is enabled.
     */
    public void onEnable() {
        System.out.println("[BrighterTorches] Initializing brighter torches mod...");

        // Load configuration
        loadConfiguration();

        if (config != null && config.isEnabled()) {
            // Apply torch modifications
            applyTorchModifications();

            System.out.println("[BrighterTorches] Plugin enabled successfully!");
            System.out.println("[BrighterTorches] Torch light level: " + config.getTorchLightLevel());
            System.out.println("[BrighterTorches] Light radius: " + config.getLightRadius());
        } else {
            System.out.println("[BrighterTorches] Plugin is disabled in config.");
        }
    }

    /**
     * Called when plugin is disabled.
     */
    public void onDisable() {
        System.out.println("[BrighterTorches] Restoring default torch settings...");

        // Restore original torch properties
        restoreTorchDefaults();

        System.out.println("[BrighterTorches] Plugin disabled!");
    }

    /**
     * Load configuration from config.json
     */
    private void loadConfiguration() {
        try {
            // Load config.json from resources or data folder
            Path configPath = Paths.get("plugins/BrighterTorches/config.json");

            // If config doesn't exist in plugins folder, use default from resources
            if (!Files.exists(configPath)) {
                System.out.println("[BrighterTorches] Using default configuration");
                config = new BrighterTorchesConfig(); // Default config
                return;
            }

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(new FileReader(configPath.toFile()), JsonObject.class);
            config = BrighterTorchesConfig.fromJson(json);

            System.out.println("[BrighterTorches] Configuration loaded successfully");
        } catch (Exception e) {
            System.err.println("[BrighterTorches] Failed to load configuration: " + e.getMessage());
            config = new BrighterTorchesConfig(); // Use defaults
        }
    }

    /**
     * Apply brighter torch modifications to the game
     *
     * NOTE: This method uses placeholder API calls that will be replaced
     * with actual Hytale API methods once they are documented.
     */
    private void applyTorchModifications() {
        System.out.println("[BrighterTorches] Applying torch modifications...");

        if (config.isModifyVanillaTorches()) {
            // TODO: Replace with actual Hytale API calls when available
            // Example expected API usage:
            // BlockRegistry.getBlock("hytale:torch").setLightLevel(config.getTorchLightLevel());
            // BlockRegistry.getBlock("hytale:wall_torch").setLightLevel(config.getWallTorchLightLevel());

            modifyTorchBlock("hytale:torch", config.getTorchLightLevel());
            modifyTorchBlock("hytale:wall_torch", config.getWallTorchLightLevel());

            if (config.isApplyToAllTorchTypes()) {
                modifyTorchBlock("hytale:soul_torch", config.getSoulTorchLightLevel());
                modifyTorchBlock("hytale:redstone_torch", config.getRedstoneTorchLightLevel());
            }
        }

        System.out.println("[BrighterTorches] Torch modifications applied");
    }

    /**
     * Modify a specific torch block's light properties
     *
     * @param blockId The block identifier (e.g., "hytale:torch")
     * @param lightLevel The new light level to apply (0-15)
     */
    private void modifyTorchBlock(String blockId, int lightLevel) {
        try {
            // TODO: Replace with actual Hytale API when available
            // This is a placeholder implementation

            System.out.println("[BrighterTorches] Setting " + blockId + " light level to " + lightLevel);

            // Expected API pattern (to be implemented when API is available):
            // Block block = BlockRegistry.getBlock(blockId);
            // if (block != null) {
            //     block.setLightEmission(lightLevel);
            //     block.setLightRadius(config.getLightRadius());
            // }

        } catch (Exception e) {
            System.err.println("[BrighterTorches] Failed to modify " + blockId + ": " + e.getMessage());
        }
    }

    /**
     * Restore default torch light levels
     */
    private void restoreTorchDefaults() {
        try {
            // TODO: Replace with actual Hytale API calls
            // Reset torches to their original light levels
            System.out.println("[BrighterTorches] Restoring default torch properties");

            // Expected API pattern:
            // BlockRegistry.getBlock("hytale:torch").resetToDefaults();

        } catch (Exception e) {
            System.err.println("[BrighterTorches] Failed to restore defaults: " + e.getMessage());
        }
    }

    /**
     * Get plugin instance
     */
    public static BrighterTorchesPlugin getInstance() {
        return instance;
    }

    /**
     * Get current configuration
     */
    public BrighterTorchesConfig getConfig() {
        return config;
    }

    /**
     * Reload configuration and reapply modifications
     */
    public void reload() {
        System.out.println("[BrighterTorches] Reloading configuration...");
        loadConfiguration();

        if (config != null && config.isEnabled()) {
            restoreTorchDefaults();
            applyTorchModifications();
            System.out.println("[BrighterTorches] Reload complete!");
        }
    }
}
