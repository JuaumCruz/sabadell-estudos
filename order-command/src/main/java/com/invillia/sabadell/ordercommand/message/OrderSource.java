package com.invillia.sabadell.ordercommand.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderSource {

    @Output(OrderQueue.OUTPUT_PROCESS)
    public MessageChannel outputProcess();

    @Output(OrderQueue.OUTPUT_MERGE)
    public MessageChannel outputMerge();

    @Input(OrderQueue.INPUT_UPDATE)
    public SubscribableChannel inputUpdate();

    class OrderQueue {
        public static final String OUTPUT_PROCESS = "output-process";

        public static final String OUTPUT_MERGE = "output-merge";

        public static final String INPUT_UPDATE = "input-update";

        private OrderQueue() {}
    }
}
