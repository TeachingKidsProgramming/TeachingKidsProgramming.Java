mkdir ~/TKPSource
cd ~/TKPSource
wget https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java/archive/master.zip
unzip master.zip
rm master.zip
mv TeachingKidsProgramming.Java-master TeachingKidsProgramming.Java
cd TeachingKidsProgramming.Java
unzip eclipse_workspace.zip
cp tkp.desktop ~/Desktop
echo Exec=$HOME/eclipse/eclipse -data $HOME/TKPSource/TeachingKidsProgramming.Java >>~/Desktop
chmod +x ~/Desktop/tkp.desktop
cd ~/
wget http://mirror.internode.on.net/pub/eclipse/technology/epp/downloads/release/luna/SR2/eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz
tar xzf eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz
rm eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz
~/eclipse/eclipse -data ~/TKPSource/TeachingKidsProgramming.Java
#sudo apt install gnome-color-chooser
