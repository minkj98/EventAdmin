import java.util.Scanner;
public class EventManager {
    static Scanner Scan = new Scanner(System.in);
    static Event[] eventList = new Event[10];
    
    EventManager(){
        boolean flag = true;
        while(flag){
            eventMenu();
            int selectMenu = Scan.nextInt();
            Scan.nextLine();
            switch(selectMenu){
                case 1:
                    registerEvent();
                    break;
                case 2:
                    modifyEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    checkTheRegisteredList();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                    break;
            }
        }
    }

    private void registerEvent() {
        System.out.println("이벤트 등록 기능입니다.");
        System.out.println("등록할 이벤트 이름을 입력하세요");
        String eventName = Scan.nextLine();
        System.out.println("이벤트 담당자 이름을 입력하세요");
        String eventManagerId = Scan.nextLine();
        int assignedEventCount = eventLimitReached(eventManagerId);
        if(assignedEventCount < 2){
            System.out.println("공개/비공개 여부를 선택하세요");
            System.out.println("1.공개 2.비공개");
            int selectVisibleOrHidden = Scan.nextInt();
            Scan.nextLine();
            boolean visibleOrHidden = true;
            if(selectVisibleOrHidden == 2){
                visibleOrHidden = false;
            }
            Event e = new Event(eventName, eventManagerId, visibleOrHidden);

            for(int i = 0; i < eventList.length; i++){
                if(eventList[i] == null){
                    eventList[i] = e;
                    System.out.println("등록을 완료했습니다." + eventList[i].eventName) ;
                    break;
                }
            }
        }else{
            System.out.println("이벤트 관리자는 2개의 이벤트만 관리할 수 있습니다.");
        }
    }

   private int eventLimitReached(String n) {
        int managerCount = 0;
        for(int i = 0; i < eventList.length; i++){
            if(eventList[i] != null){
                if(eventList[i].getEventManager().equals(n)){
                    managerCount++;


                }
            }
        }
        return managerCount;
    }

    private void modifyEvent() {
        System.out.println("이벤트 수정 기능입니다.");
        System.out.println("관리자 정보는 수정이 불가합니다.");
        System.out.println("수정을 원하는 이벤트를 입력하세요");
        String modWantEventName = Scan.nextLine();
        System.out.println("수정할 이벤트 이름을 입력하세요");
        String modAfterEventName = Scan.nextLine();
        for(int i = 0; i < eventList.length; i++){
            if(eventList[i] != null){
                if(eventList[i].getEventName().equals(modWantEventName)){
                    eventList[i].setEventName(modAfterEventName);
                    System.out.println("이벤트 이름 수정을 완료 했습니다.");
                }
            }
        }
    }

    private void deleteEvent() {
        System.out.println("이벤트 삭제 기능입니다.");
        System.out.println("삭제를 원하는 이벤트 이름을 입력하세요");
        String delEventName = Scan.nextLine();
        for(int i = 0; i < eventList.length; i++){
            if(eventList[i] != null){
                if(eventList[i].getEventName().equals(delEventName)){
                    eventList[i] = null;
                }
            }
        }
    }

    private void viewAllEvent() {
        System.out.println("이벤트 전체보기 기능입니다.");
        for(int i = 0; i < eventList.length; i++){
            if(eventList[i] != null){
                eventList[i].prt();

            }
        }
    }

    private void viewHiddenEvent() {
        System.out.println("숨긴 이벤트 보기 기능입니다.");
        for(int i = 0; i < eventList.length; i++){
            if(eventList[i] != null){
                if(!eventList[i].visibleOrHidden){
                    eventList[i].prt();
                }
            }
        }
    }

    private void checkTheRegisteredList(){
        System.out.println("등록 리스트 확인 기능입니다.");
        boolean flag = true;
        while(flag){
            System.out.println("1.전체보기 2.숨긴 이벤트 보기 3. 종료");
            System.out.println("메뉴를 선택하세요 ");
            int selectMenu = Scan.nextInt();
            Scan.nextLine();
            switch(selectMenu){
                case 1:
                    viewAllEvent();
                    break;
                case 2:
                    viewHiddenEvent();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }

    public void eventMenu(){
        System.out.println("이벤트 메뉴입니다.");
        System.out.println("1.이벤트 등록 2.이벤트 수정 3.이벤트 삭제 4.등록 리스트 확인 5.종료");
        System.out.println("이벤트 메뉴를 선택하세요");
    }
}
