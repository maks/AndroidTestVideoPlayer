# Basic Android Video Player

Useful for testing video playback via VideoView/MediaPlayer on Android.

## Usage

Start via intent:

`adb shell am start -n manichord.com.testplayer/.MainActivity --es file myvideo.mp4`

The video file needs to be in the directory returned from `Environment.getExternalStorageDirectory()`
eg. on newer versions of android its `/storage/emulated/0/` or older versions its: `/mnt/sdcard/`
