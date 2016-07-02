package by.it.sinkevich.jd01_13.TaskC;

/**
 * Класс для задания jd01_13 TaskC
 */
class TaskC {

    public static void main(String[] args) {
        try{
            VideoPlayer videoPlayer = new VideoPlayer("Sony");
            AudioPlayer audioPlayer = new AudioPlayer("Phillips");
            videoPlayer.turnOn();
            videoPlayer.play();
            audioPlayer.turnOn();
            audioPlayer.setBroken(true);
            audioPlayer.repair();
            audioPlayer.turnOn();
            audioPlayer.connectToInternet();
            videoPlayer.connectToOtherDevice(audioPlayer);
            videoPlayer.turnOff();
            audioPlayer.turnOff();
            //Метод с ошибкой для catch:
            audioPlayer.turnOff();
        } catch (PlayerException e) {
            System.out.println(e.getMessage());
        }

    }
}
