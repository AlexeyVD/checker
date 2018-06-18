# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-verbose
#-printseeds build/seeds.txt
#-printusage build/unused.txt
#-printmapping build/mapping.txt


#When not preverifing in a case-insensitive filing system, such as Windows. This tool will unpack your processed jars,(if using windows you should then use):
#-dontusemixedcaseclassnames

#Specifies not to ignore non-public library classes. As of version 4.5, this is the default setting
#-dontskipnonpubliclibraryclasses

# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
#-dontoptimize
#-dontpreverify
#
#
#-keepattributes Signature,*Annotation*,EnclosingMethod,Exceptions,SourceFile,LineNumberTable
#
#-keep class com.avd.** { *; }
#
#-keep class android.support.v4.app.** { *; }
#-keep interface android.support.v4.app.** { *; }
#
#-keep class android.support.v7.widget.** { *; }
#-keep interface android.support.v7.widget.** { *; }
#
## Crashlytics
#-keep class com.crashlytics.** { *; }
#-dontwarn com.crashlytics.**
#-keep class com.crashlytics.android.**
