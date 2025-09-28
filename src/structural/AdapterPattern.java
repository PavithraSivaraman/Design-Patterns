package structural;

//MediaPlayer interface
interface MediaPlayer {
 void play(String audioType, String filename);
}

//Existing AudioPlayer (mp3 only)
class AudioPlayer implements MediaPlayer {
 @Override
 public void play(String audioType, String filename) {
     if (audioType.equalsIgnoreCase("mp3")) {
         System.out.println("Playing mp3 file: " + filename);
     } else {
         System.out.println("Invalid media. Cannot play.");
     }
 }
}

//Advanced Media Player
interface AdvancedMediaPlayer {
 void playVlc(String filename);
 void playMp4(String filename);
}

class VlcPlayer implements AdvancedMediaPlayer {
 public void playVlc(String filename) {
     System.out.println("Playing vlc file: " + filename);
 }

 public void playMp4(String filename) { }
}

class Mp4Player implements AdvancedMediaPlayer {
 public void playVlc(String filename) { }
 public void playMp4(String filename) {
     System.out.println("Playing mp4 file: " + filename);
 }
}

//Adapter class
class MediaAdapter implements MediaPlayer {
 AdvancedMediaPlayer advancedMusicPlayer;

 public MediaAdapter(String audioType) {
     if (audioType.equalsIgnoreCase("vlc")) {
         advancedMusicPlayer = new VlcPlayer();
     } else if (audioType.equalsIgnoreCase("mp4")) {
         advancedMusicPlayer = new Mp4Player();
     }
 }

 @Override
 public void play(String audioType, String filename) {
     if (audioType.equalsIgnoreCase("vlc")) {
         advancedMusicPlayer.playVlc(filename);
     } else if (audioType.equalsIgnoreCase("mp4")) {
         advancedMusicPlayer.playMp4(filename);
     }
 }
}

//AudioPlayer with adapter
class AudioPlayerWithAdapter implements MediaPlayer {
 MediaAdapter mediaAdapter;

 @Override
 public void play(String audioType, String filename) {
     if (audioType.equalsIgnoreCase("mp3")) {
         System.out.println("Playing mp3 file: " + filename);
     } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter.play(audioType, filename);
     } else {
         System.out.println("Invalid media. Cannot play.");
     }
 }
}

//Main class
public class AdapterPattern {
 public static void main(String[] args) {
     AudioPlayerWithAdapter player = new AudioPlayerWithAdapter();
     player.play("mp3", "song.mp3");
     player.play("vlc", "movie.vlc");
     player.play("mp4", "video.mp4");
 }
}
