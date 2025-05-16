Pod::Spec.new do |s|
  s.name             = 'ffmpeg-kit-ios-full-gpl'
  s.version          = '1.0.0'
  s.summary          = 'FFmpegKit for iOS'
  s.description      = 'A fork of FFmpegKit with prebuilt binaries'
  s.homepage         = 'https://github.com/acmeacme76/ffmpeg-kit-acme'
  s.license          = { :type => 'LGPL' }
  s.author           = { 'acmeacme76' => 'iquoteacme@gmail.com' }
  s.platform         = :ios, '12.1'
  s.static_framework = true
  
  # 替换为您的二进制文件 URL
  s.source = {
    :http => 'https://github.com/acmeacme76/ffmpeg-kit-acme/releases/download/v1.0.0/ffmpeg-kit-full-gpl-1.0-ios-xcframework.zip'
  }
  
  s.vendored_frameworks = [
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/ffmpegkit.xcframework',
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/libavcodec.xcframework',
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/libavdevice.xcframework',
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/libavfilter.xcframework',
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/libavformat.xcframework',
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/libavutil.xcframework',
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/libswresample.xcframework',
    'ffmpeg-kit-full-gpl-1.0-ios-xcframework/libswscale.xcframework'
  ]
  
  s.libraries = 'z', 'bz2', 'c++', 'iconv'
  s.frameworks = 'AudioToolbox', 'AVFoundation', 'CoreMedia', 'VideoToolbox'
end