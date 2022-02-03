# Eclipse Deeplearning4j Training Labs

<p>
  <p align="center">
    <a href="https://discord.gg/sjeFMyAeZz">
        <img alt="Discord" src="https://img.shields.io/discord/783587507312263198?color=red">
    </a>
    <a href="https://skymind.education/">
        <img alt="Documentation" src="https://img.shields.io/website/https/skymind.education.svg?color=ff69b4">
    </a>
</p>

## Built with
- deeplearning4j 1.0.0-M1.1
- CUDA 11.2 (Note: Optional if you are using CPU)
- cuDNN 8.1.1 (Note: Optional if you are using CPU)

## Getting Started

### Install Java

Download Java JDK [here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).  
(Note: Use Java 8 for full support of DL4J operations)

Check the version of Java using: 
```sh
java -version
```

Make sure that 64-Bit version of Java is installed.

### Install IntelliJ IDEA Community Edition
Download and install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

### Install Apache Maven  *Optional*
IntelliJ provides a default Maven that is bundled with the installer. Follow these [instructions](https://maven.apache.org/install.html) to install Apache Maven.

### GPU setup  *Optional*
Follow the instructions below if you plan to use GPU setup.
1. Install CUDA and cuDNN
    Requirements:
   -  CUDA 11.2
   -  cuDNN 8.1.1
  
CUDA and cuDNN can be downloaded from [here](https://developer.nvidia.com/cuda-11.2.0-download-archive) and [here](https://developer.nvidia.com/rdp/cudnn-archive). Step by step installation guides can be found [here](https://docs.nvidia.com/deeplearning/sdk/cudnn-install/index.html).

2. Dependencies are needed to be included into Maven project if we wish to use GPU for training. Follow the links below for instructions in details.
   - [ND4J backends for GPUs](https://deeplearning4j.konduit.ai/multi-project/explanation/configuration/backends#nd-4-j-backends-for-gpus-and-cpus)
   - [Using Deeplearning4J with cuDNN](https://deeplearning4j.konduit.ai/multi-project/explanation/configuration/backends/cudnn#using-cudnn-via-deeplearning-4-j)
