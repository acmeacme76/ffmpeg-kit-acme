package com.arthenica.ffmpegkit.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/**
 * FFmpegKit Flutter Plugin (V2 Embedding)
 */
public class FFmpegKitFlutterPluginV2 implements FlutterPlugin, ActivityAware, PluginRegistry.ActivityResultListener {
    private static final String TAG = "FFmpegKitFlutter";
    private FlutterPluginBinding flutterPluginBinding;
    private FFmpegKitFlutterPlugin plugin;
    private ActivityPluginBinding activityPluginBinding;

    public FFmpegKitFlutterPluginV2() {
        this.plugin = new FFmpegKitFlutterPlugin();
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        Log.d(TAG, "onAttachedToEngine");
        this.flutterPluginBinding = binding;
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        Log.d(TAG, "onDetachedFromEngine");
        if (plugin != null) {
            plugin.onDetachedFromEngine(binding);
        }
        this.flutterPluginBinding = null;
    }

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        Log.d(TAG, "onAttachedToActivity");
        this.activityPluginBinding = binding;
        if (plugin != null && flutterPluginBinding != null) {
            binding.addActivityResultListener(this);
            plugin.init(
                flutterPluginBinding.getBinaryMessenger(),
                flutterPluginBinding.getApplicationContext(),
                binding.getActivity(),
                null,
                binding
            );
        }
    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {
        Log.d(TAG, "onDetachedFromActivityForConfigChanges");
        if (plugin != null) {
            plugin.onDetachedFromActivity();
        }
        this.activityPluginBinding = null;
    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        Log.d(TAG, "onReattachedToActivityForConfigChanges");
        onAttachedToActivity(binding);
    }

    @Override
    public void onDetachedFromActivity() {
        Log.d(TAG, "onDetachedFromActivity");
        if (plugin != null) {
            if (activityPluginBinding != null) {
                activityPluginBinding.removeActivityResultListener(this);
            }
            plugin.onDetachedFromActivity();
        }
        this.activityPluginBinding = null;
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (plugin != null) {
            return plugin.onActivityResult(requestCode, resultCode, data);
        }
        return false;
    }
}
