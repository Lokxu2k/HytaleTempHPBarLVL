package com.brightertorches;

import com.google.gson.JsonObject;

/**
 * Configuration class for BrighterTorches plugin
 *
 * Handles loading and managing torch brightness settings.
 *
 * @author Claude
 * @version 1.0.0
 */
public class BrighterTorchesConfig {

    // Brightness settings
    private int torchLightLevel;
    private int wallTorchLightLevel;
    private int soulTorchLightLevel;
    private int redstoneTorchLightLevel;
    private boolean enabled;

    // Advanced settings
    private boolean modifyVanillaTorches;
    private boolean applyToAllTorchTypes;
    private int lightRadius;

    /**
     * Create default configuration
     */
    public BrighterTorchesConfig() {
        // Default values (vanilla is typically 14 for torches)
        this.torchLightLevel = 15;
        this.wallTorchLightLevel = 15;
        this.soulTorchLightLevel = 12;
        this.redstoneTorchLightLevel = 10;
        this.enabled = true;

        this.modifyVanillaTorches = true;
        this.applyToAllTorchTypes = true;
        this.lightRadius = 20;
    }

    /**
     * Create configuration from JSON
     */
    public static BrighterTorchesConfig fromJson(JsonObject json) {
        BrighterTorchesConfig config = new BrighterTorchesConfig();

        try {
            // Load brightness settings
            if (json.has("brightness")) {
                JsonObject brightness = json.getAsJsonObject("brightness");

                if (brightness.has("torchLightLevel")) {
                    config.torchLightLevel = brightness.get("torchLightLevel").getAsInt();
                }
                if (brightness.has("wallTorchLightLevel")) {
                    config.wallTorchLightLevel = brightness.get("wallTorchLightLevel").getAsInt();
                }
                if (brightness.has("soulTorchLightLevel")) {
                    config.soulTorchLightLevel = brightness.get("soulTorchLightLevel").getAsInt();
                }
                if (brightness.has("redstoneTorchLightLevel")) {
                    config.redstoneTorchLightLevel = brightness.get("redstoneTorchLightLevel").getAsInt();
                }
                if (brightness.has("enabled")) {
                    config.enabled = brightness.get("enabled").getAsBoolean();
                }
            }

            // Load advanced settings
            if (json.has("advanced")) {
                JsonObject advanced = json.getAsJsonObject("advanced");

                if (advanced.has("modifyVanillaTorches")) {
                    config.modifyVanillaTorches = advanced.get("modifyVanillaTorches").getAsBoolean();
                }
                if (advanced.has("applyToAllTorchTypes")) {
                    config.applyToAllTorchTypes = advanced.get("applyToAllTorchTypes").getAsBoolean();
                }
                if (advanced.has("lightRadius")) {
                    config.lightRadius = advanced.get("lightRadius").getAsInt();
                }
            }

            // Validate light levels (0-15 is typical for Minecraft-like games)
            config.torchLightLevel = clamp(config.torchLightLevel, 0, 15);
            config.wallTorchLightLevel = clamp(config.wallTorchLightLevel, 0, 15);
            config.soulTorchLightLevel = clamp(config.soulTorchLightLevel, 0, 15);
            config.redstoneTorchLightLevel = clamp(config.redstoneTorchLightLevel, 0, 15);

        } catch (Exception e) {
            System.err.println("[BrighterTorches] Error parsing config: " + e.getMessage());
        }

        return config;
    }

    /**
     * Clamp a value between min and max
     */
    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    // Getters

    public int getTorchLightLevel() {
        return torchLightLevel;
    }

    public int getWallTorchLightLevel() {
        return wallTorchLightLevel;
    }

    public int getSoulTorchLightLevel() {
        return soulTorchLightLevel;
    }

    public int getRedstoneTorchLightLevel() {
        return redstoneTorchLightLevel;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isModifyVanillaTorches() {
        return modifyVanillaTorches;
    }

    public boolean isApplyToAllTorchTypes() {
        return applyToAllTorchTypes;
    }

    public int getLightRadius() {
        return lightRadius;
    }

    // Setters

    public void setTorchLightLevel(int torchLightLevel) {
        this.torchLightLevel = clamp(torchLightLevel, 0, 15);
    }

    public void setWallTorchLightLevel(int wallTorchLightLevel) {
        this.wallTorchLightLevel = clamp(wallTorchLightLevel, 0, 15);
    }

    public void setSoulTorchLightLevel(int soulTorchLightLevel) {
        this.soulTorchLightLevel = clamp(soulTorchLightLevel, 0, 15);
    }

    public void setRedstoneTorchLightLevel(int redstoneTorchLightLevel) {
        this.redstoneTorchLightLevel = clamp(redstoneTorchLightLevel, 0, 15);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setModifyVanillaTorches(boolean modifyVanillaTorches) {
        this.modifyVanillaTorches = modifyVanillaTorches;
    }

    public void setApplyToAllTorchTypes(boolean applyToAllTorchTypes) {
        this.applyToAllTorchTypes = applyToAllTorchTypes;
    }

    public void setLightRadius(int lightRadius) {
        this.lightRadius = lightRadius;
    }

    @Override
    public String toString() {
        return "BrighterTorchesConfig{" +
                "torchLightLevel=" + torchLightLevel +
                ", wallTorchLightLevel=" + wallTorchLightLevel +
                ", soulTorchLightLevel=" + soulTorchLightLevel +
                ", redstoneTorchLightLevel=" + redstoneTorchLightLevel +
                ", enabled=" + enabled +
                ", modifyVanillaTorches=" + modifyVanillaTorches +
                ", applyToAllTorchTypes=" + applyToAllTorchTypes +
                ", lightRadius=" + lightRadius +
                '}';
    }
}
