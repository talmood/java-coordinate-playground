public class InputView {
	
	public static CoordinateRequest inputCoordinate() {
		System.out.println("> 좌표를 입력하세요.");
		final var coordinates = Console.readLine();
		return CoordinateRequest.from(coordinates);
	}
}
