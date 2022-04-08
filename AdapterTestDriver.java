import java.util.*;

interface Duck
{
    public void quack();
    public void fly();
}

class MallardDuck implements Duck
{
    public void quack() {
	System.out.println("�в�!");
    }
    public void fly() {
	System.out.println("����~");
    }
}

class RubberDuck implements Duck
{
    public void quack() {
	System.out.println("���!");
    }
    public void fly() {
	System.out.println("��¦����");
    }
}

interface Turkey
{
    public void gobble();
    public void fly();
}

class WildTurkey implements Turkey
{
    public void gobble() {
	System.out.println("���!");
    }
    public void fly() {
	System.out.println("�Ĵٴ�~");
    }
}

class TurkeyAdapter implements Duck
{
    Turkey turkey;
    TurkeyAdapter(Turkey t) {
	turkey = t;
    }
    public void quack() {
	turkey.gobble();
    }
    public void fly() {
	turkey.fly();
    }
}

class  AdapterTestDriver
{
	public static void main(String[] args) 
	{
	    Duck d1 = new MallardDuck();
	    Duck d2 = new RubberDuck();
	    Duck d3 = new RubberDuck();
	    Duck d4 = new RubberDuck();

	    Duck d5 = new TurkeyAdapter(new WildTurkey());
	    Duck d6 = new TurkeyAdapter(new WildTurkey());

	    ArrayList<Duck> flock = new ArrayList<Duck>();

	    flock.add(d1);
	    flock.add(d2);
	    flock.add(d3);
	    flock.add(d4);
	    flock.add(d5);
	    flock.add(d6);

	    for (Duck d : flock)
	    {
		d.quack();
		d.fly();
	    }

	}
}
