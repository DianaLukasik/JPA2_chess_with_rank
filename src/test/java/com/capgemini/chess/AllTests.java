package com.capgemini.chess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.capgemini.chess.dataaccess.dao.impl.GameDaoImplTest;
import com.capgemini.chess.service.impl.GameServiceImplTest;
import com.capgemini.chess.service.impl.UserServiceFacadeImplTest;
import com.capgemini.chess.service.impl.UserValidationServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ UserServiceFacadeImplTest.class, UserValidationServiceImplTest.class, GameServiceImplTest.class,
		GameDaoImplTest.class })
public class AllTests {

}
