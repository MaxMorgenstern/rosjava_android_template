package org.ollide.rosandroid;

import org.apache.commons.logging.Log;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;

/**
 * Created by maximilianporzelt on 08.04.17.
 * Note: http://rosjava.github.io/rosjava_core/0.1.6/getting_started.html
 */

public class SimpleSubscriberNode  extends AbstractNodeMain {

    private static final String TAG = SimpleSubscriberNode.class.getSimpleName();

    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("SimpleSubscriberNode/ListenerNode");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {
        final Log log = connectedNode.getLog();
        Subscriber<std_msgs.String> subscriber = connectedNode.newSubscriber("chatter", std_msgs.String._TYPE);
        subscriber.addMessageListener(new MessageListener<std_msgs.String>() {
            @Override
            public void onNewMessage(std_msgs.String message) {
                log.info("I heard: \"" + message.getData() + "\"");
            }
        });
    }
}
