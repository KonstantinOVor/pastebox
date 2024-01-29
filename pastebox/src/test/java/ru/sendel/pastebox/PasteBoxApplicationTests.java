//package ru.sendel.pastebox;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import ru.sendel.pastebox.exception.NotFoundException;
//import ru.sendel.pastebox.service.PasteBoxService;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@SpringBootTest
//public class PasteBoxApplicationTests {
//
//	@Autowired
//	private PasteBoxService pasteBoxService;
//
//	@Test
//	public void notExistHash() {
//		assertThrows(NotFoundException.class, () ->
//			pasteBoxService.getByHash("123")
//		);
//	}
//}
