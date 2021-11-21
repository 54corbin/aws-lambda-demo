
java_binary(
  name = 'lambda',
  srcs = glob(
  [
    "src/main/java/com/chb/*.java",

  ]),
  main_class = "com.chb.Main",
  deps = [
    "@maven//:com_amazonaws_aws_java_sdk",
    "@maven//:com_amazonaws_aws_java_sdk_core",
    "@maven//:com_amazonaws_aws_java_sdk_lambda",
  ],
)

