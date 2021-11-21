package com.chb;

import java.util.*;
import com.amazonaws.regions.*;
import com.amazonaws.auth.profile.*;
import com.amazonaws.services.lambda.*;
import com.amazonaws.services.lambda.model.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void invoke(String functionName) throws Exception{


        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(functionName)
                .withPayload("{\n" +
                        " \"Hello \": \"Paris\",\n" +
                        " \"countryCode\": \"FR\"\n" +
                        "}");
        InvokeResult invokeResult = null;

            AWSLambda awsLambda = AWSLambdaClientBuilder.defaultClient();
            invokeResult = awsLambda.invoke(invokeRequest);

            String ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);

            System.out.println(ans);

        System.out.println(invokeResult.getStatusCode());
    }

        public static List<FunctionConfiguration> listFunc() {

        // snippet-start:[lambda.java1.list.main]
        ListFunctionsResult functionResult = null;

            AWSLambda awsLambda = AWSLambdaClientBuilder.defaultClient();

            functionResult = awsLambda.listFunctions();

            List<FunctionConfiguration> list = functionResult.getFunctions();

            for (Iterator iter = list.iterator(); iter.hasNext();) {
                FunctionConfiguration config = (FunctionConfiguration) iter.next();

                System.out.println("The function name is " + config.getFunctionName());
            }

            return list;

    }

    public static void main(String[] args) throws Exception {
        System.out.println("hello !!!");

        listFunc();

        invoke("java-function-demo");


    }
}
