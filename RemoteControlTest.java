class Light
{
    String where;
    Light(String where) {
	this.where = where;
    }

    void on() {
	System.out.println("Light in " + where + " is on.");
    }

    void off() {
	System.out.println("Light in " + where + " is off.");
    }
}

class TV
{
    TV() {
    }

    void on() {
	System.out.println("TV is on.");
    }

    void off() {
	System.out.println("TV is off.");
    }
}

class SimpleRemoteControl
{
    Command[] onCommands;
    Command[] offCommands;

    SimpleRemoteControl() {
	onCommands = new Command[7];
	offCommands = new Command[7];
    }

    void setCommand(int slot, Command on, Command off) {
	onCommands[slot] = on;
	offCommands[slot] = off;
    }

    void buttonOnPressed(int i) {
	onCommands[i].execute();
    }

    void buttonOffPressed(int i) {
	offCommands[i].execute();
    }
}

interface Command
{
    public void execute();
}

class LightOnCommand implements Command
{
    Light light;
    LightOnCommand(Light l) {
	light = l;
    }
    public void execute() {
	light.on();
    }
}

class LightOffCommand implements Command
{
    Light light;
    LightOffCommand(Light l) {
	light = l;
    }
    public void execute() {
	light.off();
    }
}

class TVOnCommand implements Command
{
    TV tv;
    TVOnCommand(TV l) {
	tv = l;
    }
    public void execute() {
	tv.on();
    }
}

class TVOffCommand implements Command
{
    TV tv;
    TVOffCommand(TV l) {
	tv = l;
    }
    public void execute() {
	tv.off();
    }
}

class RemoteControlTest 
{
	public static void main(String[] args) 
	{
	    SimpleRemoteControl remote = new SimpleRemoteControl();

	    Light x = new Light("living room");
	    Light y = new Light("kitchen");
	    TV z = new TV();

	    LightOnCommand n1 = new LightOnCommand(x);
	    LightOnCommand n2 = new LightOnCommand(y);
	    TVOnCommand n3 = new TVOnCommand(z);

	    LightOffCommand f1 = new LightOffCommand(x);
	    LightOffCommand f2 = new LightOffCommand(y);
	    TVOffCommand f3 = new TVOffCommand(z); //갈아끼기쉬움 (if문 없애기)

	    remote.setCommand(0, n1, f1);
	    remote.setCommand(1, n2, f2);
	    remote.setCommand(2, n3, f3);

	    remote.buttonOnPressed(2);
	    remote.buttonOffPressed(0);
	}
}
