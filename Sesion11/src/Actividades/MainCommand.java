package Actividades;

//Interfaz Command
interface Command {
 void execute();
}

//Receptor
class TV {
 public void turnOn() {
     System.out.println("Televisor encendido.");
 }

 public void turnOff() {
     System.out.println("Televisor apagado.");
 }

 public void changeChannel(int channel) {
     System.out.println("Canal cambiado a: " + channel);
 }

 public void adjustVolume(int volume) {
     System.out.println("Volumen ajustado a: " + volume);
 }
}

//Comandos concretos
class TurnOnCommand implements Command {
 private TV tv;

 public TurnOnCommand(TV tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.turnOn();
 }
}

class TurnOffCommand implements Command {
 private TV tv;

 public TurnOffCommand(TV tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.turnOff();
 }
}

class ChangeChannelCommand implements Command {
 private TV tv;
 private int channel;

 public ChangeChannelCommand(TV tv, int channel) {
     this.tv = tv;
     this.channel = channel;
 }

 @Override
 public void execute() {
     tv.changeChannel(channel);
 }
}

class AdjustVolumeCommand implements Command {
 private TV tv;
 private int volume;

 public AdjustVolumeCommand(TV tv, int volume) {
     this.tv = tv;
     this.volume = volume;
 }

 @Override
 public void execute() {
     tv.adjustVolume(volume);
 }
}

//Invocador
class RemoteControl {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}

//Clase Principal
public class MainCommand {
 public static void main(String[] args) {
     TV tv = new TV();
     RemoteControl remote = new RemoteControl();

     remote.setCommand(new TurnOnCommand(tv));
     remote.pressButton();

     remote.setCommand(new ChangeChannelCommand(tv, 5));
     remote.pressButton();

     remote.setCommand(new AdjustVolumeCommand(tv, 15));
     remote.pressButton();

     remote.setCommand(new TurnOffCommand(tv));
     remote.pressButton();
 }
}
