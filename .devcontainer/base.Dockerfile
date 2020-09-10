ARG VARIANT=11
FROM openjdk:${VARIANT}-jdk-buster

ARG INSTALL_ZSH="true"
ARG UPGRADE_PACKAGES="true"

ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=$USER_UID
COPY library-scripts/common-debian.sh /tmp/library-scripts/
RUN bash /tmp/library-scripts/common-debian.sh "${INSTALL_ZSH}" "${USERNAME}" "${USER_UID}" "${USER_GID}" "${UPGRADE_PACKAGES}" \
    && if [ ! -d "/docker-java-home" ]; then ln -s "${JAVA_HOME}" /docker-java-home; fi \
    && apt-get clean -y && rm -rf /var/lib/apt/lists/* /tmp/library-scripts

ARG INSTALL_MAVEN="true"
ARG MAVEN_VERSION=""
ENV SDKMAN_DIR="/usr/local/sdkman"
ENV PATH="${PATH}:${SDKMAN_DIR}/java/current/bin:${SDKMAN_DIR}/maven/current/bin:${SDKMAN_DIR}/gradle/current/bin"
COPY library-scripts/java-debian.sh library-scripts/maven-debian.sh library-scripts/gradle-debian.sh /tmp/library-scripts/
RUN bash /tmp/library-scripts/java-debian.sh "none" "${SDKMAN_DIR}" "${USERNAME}" "true" \
    && if [ "${INSTALL_MAVEN}" = "true" ]; then bash /tmp/library-scripts/maven-debian.sh "${MAVEN_VERSION:-latest}" "${SDKMAN_DIR}" ${USERNAME} "true"; fi \
    && apt-get clean -y && rm -rf /var/lib/apt/lists/* /tmp/library-scripts
