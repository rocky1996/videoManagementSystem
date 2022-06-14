package com.example.videomanagementsystem.util;

import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Future;

@Slf4j
public class SpeechRecognizeUtil {

    public static String recognize(String targetFilePath) {
        try {
            SpeechConfig speechConfig = SpeechConfig.fromSubscription("aecff464cd81425eaa96bb96dcf73a55", "chinanorth2");
            speechConfig.setSpeechRecognitionLanguage("en-US");
            AudioConfig audioConfig = AudioConfig.fromWavFileInput(targetFilePath);

            SpeechRecognizer speechRecognizer = new SpeechRecognizer(speechConfig,"en-US", audioConfig);
            Future<SpeechRecognitionResult> task = speechRecognizer.recognizeOnceAsync();
            SpeechRecognitionResult speechRecognitionResult = task.get();
            if (speechRecognitionResult.getReason() != ResultReason.RecognizedSpeech) {
                log.info("SpeechRecognizeUtil.recognize reason is not recognizedSpeech");
                return null;
            }
            return speechRecognitionResult.getText();
        }catch (Exception e) {
            log.error("SpeechRecognizeUtil.recognize has error", e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        String targetFilePath = "C:\\home\\telangpu.wav";
        String value = recognize(targetFilePath);
        System.out.println(value);
    }
}
