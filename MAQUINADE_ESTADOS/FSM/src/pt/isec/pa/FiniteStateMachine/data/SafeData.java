package pt.isec.pa.FiniteStateMachine.data;

import javax.xml.crypto.dom.DOMCryptoContext;

public class SafeData {
    //safe data --> são os dados do cofre, não é dados seguros

    private static final String CODE_PIN ="1234";
    private static final String CODE_PUK="123456";
    private static final int MAX_ATTEMPTS=3;

    private boolean doorOpened;

    private int failed_attempts;

    private double money;

    public SafeData(){
        doorOpened = false;
        failed_attempts=0;
        money=0.0;
    }

    public boolean isDoorOpened(){return doorOpened;}
    public boolean isBlocked(){
        return failed_attempts >=MAX_ATTEMPTS;
    }

    public int getFailedAttempts(){return failed_attempts;}

    public double getMoney(){return money;}


    public boolean depositMoney(double amount){
        if(!doorOpened || amount<=0) return false;

        money+=amount;
        return true;
    }
    public boolean withdrawMoney(double amount){
        if(!doorOpened || amount<=0 || amount >money) return false;
        money -= amount;
        return true;
    }
    public boolean open(String code){
        if(code == null ||doorOpened || isBlocked())
            return false;
        if(code.equals(CODE_PIN)){
            doorOpened=true;
            failed_attempts=0;
            return true;
        }
        ++failed_attempts;
        return false;
    }
    public boolean unblock(String code){
        if (code ==null || isBlocked())
        if (code.equals(CODE_PUK)){
            failed_attempts =0;
            return true;
        }
        return false;
    }

    public boolean close(){
        if(!doorOpened||isBlocked())
            return false;
        doorOpened=false;
        return true;
    }




}
