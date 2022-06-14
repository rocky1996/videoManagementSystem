package com.example.videomanagementsystem.util;

import com.example.videomanagementsystem.constants.UrlConstants;
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
            SpeechConfig speechConfig =
                    SpeechConfig.fromSubscription(UrlConstants.SECRET_KEY, UrlConstants.AREA);
            speechConfig.setSpeechRecognitionLanguage(UrlConstants.LANGUAGE_TYPE);
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
