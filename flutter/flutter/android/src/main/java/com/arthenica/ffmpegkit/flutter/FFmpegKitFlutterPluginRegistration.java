package com.arthenica.ffmpegkit.flutter;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;

/**
 * FFmpegKitFlutterPluginRegistration
 * 
 * <p>This class registers the FFmpegKit Flutter plugin with the Flutter engine.
 */
@Keep
public class FFmpegKitFlutterPluginRegistration {
    /**
     * Registers the plugin with the Flutter engine.
     * 
     * <p>This method is called by the Flutter engine when the plugin is registered.
     * It creates a new instance of the plugin and adds it to the Flutter engine's plugin registry.
     *
     * @param flutterPluginBinding The Flutter plugin binding that provides access to the Flutter engine.
     */
    public static void registerWith(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        FFmpegKitFlutterPluginV2 plugin = new FFmpegKitFlutterPluginV2();
        plugin.onAttachedToEngine(flutterPluginBinding);
    }
}
