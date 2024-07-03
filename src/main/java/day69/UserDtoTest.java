package day69;

public class UserDtoTest {
    public static void main(String[] args){
        UserDto dto = new UserDto();

        dto.setAge(20);
        dto.setName("홍길동");
        dto.setAddr("서울");

        UserChainingDto dto2 = new UserChainingDto();
//        UserChainingDto.setAge(20).setName("홍길동").setAddr("서울");


        //1. dto2.setAge(20)이 메소드 뒤에 . 을 적을 수 있는 이유는 참조변수값을 리턴하기 때문
        //2. 1번 리턴주소값.setName("유관순")
        //3. 2번 리턴 주소값.setAddr("대구")
        //4. dd = 3번 리턴 주소값
        System.out.println(dto);
        System.out.println(dto2);
    }
}
