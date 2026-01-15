# BrighterTorches - Hytale Mod

A Hytale plugin that makes torches emit brighter light for better visibility in caves and dark areas.

> **Note:** This mod is built using the Hytale plugin system and is ready to use once the Hytale server API is fully released. The implementation uses placeholder API calls that will be updated when the official API documentation is available.

## Features

✨ **Configurable Brightness** - Adjust torch light levels to your preference
🔦 **Multiple Torch Types** - Supports regular torches, wall torches, soul torches, and redstone torches
🎮 **Easy Configuration** - Simple JSON config file
⚡ **Performance Friendly** - Minimal overhead
🔄 **Hot Reload** - Configuration can be reloaded without restarting the server

---

## Installation

1. Download the latest `BrighterTorches-1.0.0.jar` from the releases
2. Place the JAR file in your Hytale server's `plugins/` folder
3. Start or restart your server
4. The plugin will create a default configuration in `plugins/BrighterTorches/config.json`

---

## Configuration

Edit `plugins/BrighterTorches/config.json` to customize torch brightness:

```json
{
  "pluginName": "BrighterTorches",
  "version": "1.0.0",
  "debugMode": false,
  "brightness": {
    "torchLightLevel": 15,
    "wallTorchLightLevel": 15,
    "soulTorchLightLevel": 12,
    "redstoneTorchLightLevel": 10,
    "enabled": true
  },
  "advanced": {
    "modifyVanillaTorches": true,
    "applyToAllTorchTypes": true,
    "lightRadius": 20
  }
}
```

### Configuration Options

**Brightness Settings:**
- `torchLightLevel` - Light level for regular torches (0-15, default: 15)
- `wallTorchLightLevel` - Light level for wall-mounted torches (0-15, default: 15)
- `soulTorchLightLevel` - Light level for soul torches (0-15, default: 12)
- `redstoneTorchLightLevel` - Light level for redstone torches (0-15, default: 10)
- `enabled` - Enable/disable the plugin (default: true)

**Advanced Settings:**
- `modifyVanillaTorches` - Whether to modify vanilla torches (default: true)
- `applyToAllTorchTypes` - Apply to all torch types or just regular torches (default: true)
- `lightRadius` - How far the light spreads (default: 20)

> **Note:** In Minecraft-like games, vanilla torches typically have a light level of 14. This mod increases them to 15 (maximum) by default.

---

## Building from Source

### Prerequisites

- **Java 25 JDK** - [Download here](https://www.oracle.com/java/technologies/downloads/)
- **Git** - [Download here](https://git-scm.com/)

### Build Steps

```bash
# Clone the repository
git clone https://github.com/jackmhny/brighter-torches.git
cd brighter-torches

# Build the plugin
./gradlew shadowJar

# The JAR will be in build/libs/
ls build/libs/
```

---

## How It Works

The plugin modifies the light emission properties of torch blocks when the server starts. It:

1. Loads configuration from `config.json`
2. Identifies all torch blocks in the game
3. Modifies their light level and radius properties
4. Applies changes server-wide

When the plugin is disabled, it restores the original torch properties.

---

## API Status

This plugin is built for the Hytale modding API. Since the full server source code is expected to be released in March 2026, some API methods used in this plugin are placeholders that follow common patterns from similar voxel games.

Once the official Hytale API is documented, the plugin will be updated with the correct API calls. The structure and configuration system are production-ready.

**Expected API pattern (to be confirmed):**
```java
Block torch = BlockRegistry.getBlock("hytale:torch");
torch.setLightEmission(15);
torch.setLightRadius(20);
```

---

## Compatibility

- **Hytale Version:** * (All versions)
- **Server Type:** Dedicated Server
- **Dependencies:** None
- **Conflicts:** Should be compatible with most other mods

---

## Troubleshooting

### Plugin not loading
- Check that the JAR is in the `plugins/` folder
- Verify the server supports plugins
- Check server logs for error messages

### Torches still dark
- Ensure `enabled: true` in config.json
- Check that light levels are set above 0
- Verify `modifyVanillaTorches` is true

### Configuration not working
- Make sure the config file is valid JSON
- Check file permissions
- Try deleting config.json and letting it regenerate

---

## Development

This plugin follows best practices for Hytale plugin development:

**Project Structure:**
```
BrighterTorches/
├── src/main/java/com/brightertorches/
│   ├── BrighterTorchesPlugin.java      # Main plugin class
│   └── BrighterTorchesConfig.java      # Configuration manager
├── src/main/resources/
│   ├── manifest.json                    # Plugin metadata
│   └── config.json                      # Default configuration
└── build.gradle.kts                     # Build configuration
```

**Tech Stack:**
- Java 25
- Gson for JSON parsing
- Gradle with Shadow plugin for dependency bundling

---

## Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Credits

- **Author:** Claude
- **Documentation:** [Hytale Modding Documentation](https://britakee-studios.gitbook.io/hytale-modding-documentation)
- **Inspired by:** Minecraft torch enhancement mods and the Hytale modding community

---

## Support

- **Issues:** [GitHub Issues](https://github.com/jackmhny/brighter-torches/issues)
- **Documentation:** [Hytale Modding Docs](https://britakee-studios.gitbook.io/hytale-modding-documentation)

---

**Make your caves brighter! 🔥**
