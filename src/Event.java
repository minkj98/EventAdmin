public class Event {
    String eventName = null;
    String eventManager = null;
    boolean visibleOrHidden = true;

    public Event(String eventName, String eventManager, boolean visibleOrHidden) {
        this.eventName = eventName;
        this.eventManager = eventManager;
        this.visibleOrHidden = visibleOrHidden;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventManager() {
        return eventManager;
    }

    public void setEventManager(String eventManager) {
        this.eventManager = eventManager;
    }

    public void prt(){
        System.out.println("-----이벤트 정보-----");
        System.out.println("이벤트 이름: " + this.eventName);
        System.out.println("이벤트 관리자: " + this.eventManager);
        if(visibleOrHidden){
            System.out.println("공개");

        }else{
            System.out.println("비공개");
        }
    }


}