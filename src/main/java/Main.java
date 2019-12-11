import com.demo.protobuf.DemoProtoBuf;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author ligen
 * @title: Main
 * @projectName protobuf
 * @description:
 * @date 2019/12/510:22
 */
public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {

        DemoProtoBuf.Demo.Builder builder = DemoProtoBuf.Demo.newBuilder();

        DemoProtoBuf.Demo.DemoMessage.Builder builder1 = DemoProtoBuf.Demo.DemoMessage.newBuilder();

        builder.setId(1);
        builder.setValue("0xffffff");
        builder.addLikes("chifanfan");
        builder.addLikes("shuijiaojiao");


        builder1.setColor(DemoProtoBuf.Demo.Color.BLUE);


        // 序列化
        DemoProtoBuf.Demo demo = builder.build();
        DemoProtoBuf.Demo.DemoMessage demo2 = builder1.build();
        System.out.println("builder1 before:" + demo);
        System.out.println("builder2 before:" + demo2);


        // builder打印之后的序列化结果
        System.out.println("builder序列化结果为:");
        for (byte b : demo.toByteArray()) {
            System.out.print(b);
        }

        // builder1打印之后的序列化结果
        System.out.println("\r\nbuilder1序列化结果为:");
        for (byte b : demo2.toByteArray()) {
            System.out.print(b);
        }



        //  反序列化
        System.out.println("\r\n反序列化结果为");
        byte[] bytes1 = demo.toByteArray();
        byte[] bytes2 = demo2.toByteArray();
        DemoProtoBuf.Demo result = DemoProtoBuf.Demo.parseFrom(bytes1);
        DemoProtoBuf.Demo.DemoMessage result1 = DemoProtoBuf.Demo.DemoMessage.parseFrom(bytes2);
        System.out.println("result1 "+result);
        System.out.println("result2 "+result1);

    }
}
