# JenkinsTest





pipeline {
2
agent {
3
label "master"
4
}
5
tools {
6
maven "Maven"
7
}
8
environment {
9
NEXUS_VERSION = "nexus3"
10
NEXUS_PROTOCOL = "http"
11
NEXUS_URL = "you-ip-addr-here:8081"
12
NEXUS_REPOSITORY = "maven-nexus-repo"
13
NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
14
}
15
stages {
16
stage("Clone code from VCS") {
17
steps {
18
script {
19
git 'https://github.com/javaee/cargotracker.git';
20
}
21
}
22
}
23
stage("Maven Build") {
24
steps {
25
script {
26
sh "mvn package -DskipTests=true"
27
}
28
}
29
}
30
stage("Publish to Nexus Repository Manager") {
31
steps {
32
script {
33
pom = readMavenPom file: "pom.xml";
34
filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
35
echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
36
artifactPath = filesByGlob[0].path;
37
artifactExists = fileExists artifactPath;
38
if(artifactExists) {
39
echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
40
nexusArtifactUploader(
41
nexusVersion: NEXUS_VERSION,
42
protocol: NEXUS_PROTOCOL,
43
nexusUrl: NEXUS_URL,
44
groupId: pom.groupId,
45
version: pom.version,
46
repository: NEXUS_REPOSITORY,
47
credentialsId: NEXUS_CREDENTIAL_ID,
48
artifacts: [
49
[artifactId: pom.artifactId,
50
classifier: '',
51
file: artifactPath,
52
type: pom.packaging],
53
[artifactId: pom.artifactId,
54
classifier: '',
55
file: "pom.xml",
56
type: "pom"]
57
]
58
);
59
} else {
60
error "*** File: ${artifactPath}, could not be found";
61
}
62
}
63
}
64
}
65
}
66
}