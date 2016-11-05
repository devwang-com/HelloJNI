cmake_minimum_required(VERSION 3.4.1)

add_library(hellojni SHARED
            hello-jni.c)

# Include libraries needed for hello-jni lib
target_link_libraries(hellojni
                      android
                      log)
