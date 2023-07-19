
how the behavior works:

    Concurrency: The setConcurrency method sets the minimum and maximum number of concurrent consumers. It controls how many consumer threads can process messages simultaneously. For example, with a concurrency setting of "3-10", there can be a minimum of 3 and a maximum of 10 concurrent consumer threads.

    setMaxMessagesPerTask: The setMaxMessagesPerTask method determines the maximum number of messages processed by each consumer task. In your case, it is set to 10. This means that each consumer thread will process up to 10 messages before starting a new task.

However, it's important to note that if there are fewer messages available in the service bus queue/topic at a given time, the consumers will consume the available messages without waiting for a complete batch of 10 messages. They will process the available messages in the queue/topic until there are no more messages or until they reach the setMaxMessagesPerTask limit.

So, the behavior is that consumers will process messages concurrently and consume as many messages as possible, up to the setMaxMessagesPerTask limit, but it doesn't guarantee that there will always be a complete batch of messages. If there are fewer messages available, they will still be consumed.