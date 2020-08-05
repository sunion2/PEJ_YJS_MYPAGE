package PEJ;

import PEJ.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OnePlusViewViewHandler {


    @Autowired
    private OnePlusViewRepository onePlusViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSetOnePlused_then_CREATE_1 (@Payload SetOnePlused setOnePlused) {

System.out.println("##### whenSetOnePlused_then_CREATE_1 : " + setOnePlused.getPrdId());

        try {
            if (setOnePlused.isMe()) {

System.out.println("##### whenSetOnePlused_then_CREATE_1 : " + setOnePlused.getPrdId());

                // view 객체 생성
                OnePlusView onePlusView = new OnePlusView();
                // view 객체에 이벤트의 Value 를 set 함
                onePlusView.setPrdId(setOnePlused.getPrdId());
                onePlusView.setPrdAttrCd(setOnePlused.getPrdAttrCd());
                // view 레파지 토리에 save
                onePlusViewRepository.save(onePlusView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCancelOneplused_then_UPDATE_1(@Payload CancelOneplused cancelOneplused) {

System.out.println("##### whenCancelOneplused_then_UPDATE_1 : " + cancelOneplused.getPrdId());

        try {
            if (cancelOneplused.isMe()) {

System.out.println("##### whenCancelOneplused_then_UPDATE_2 : " + cancelOneplused.getPrdId());

                // view 객체 조회
                List<OnePlusView> onePlusViewList = onePlusViewRepository.findByPrdId(cancelOneplused.getPrdId());
                for(OnePlusView onePlusView : onePlusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    onePlusView.setPrdAttrCd(cancelOneplused.getPrdAttrCd());
                    // view 레파지 토리에 save
                    onePlusViewRepository.save(onePlusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}