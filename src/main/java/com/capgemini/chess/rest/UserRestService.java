// package com.capgemini.chess.rest;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import com.capgemini.chess.dao.UserDao;
// import com.capgemini.chess.service.RankingService;
// import com.capgemini.chess.service.to.UserTO;
//
// @Controller
// @ResponseBody
// public class UserRestService {
//
// @Autowired
// private UserDao userDao;
//
// @Autowired
// private RankingService rankService;
//
// @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
// public UserTO findUserById(@RequestParam("id") Long id) {
// return userDao.findOne(id);
// }
//
// @RequestMapping(value = "/ranking/{id}", method = RequestMethod.GET)
// public int showRankPositionForUser(@RequestParam("userId") Long userId) {
// return rankService.getRankingPositionForUser(userId);
// }
//
// @RequestMapping(value = "/update/{user}", method = RequestMethod.POST)
// public UserTO updateUser(@RequestParam("user") UserTO user) {
// return userDao.update(user);
// }
// }