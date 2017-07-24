package id.ac.dharmaiswara.app.service;

import id.ac.dharmaiswara.app.model.Choice;
import id.ac.dharmaiswara.app.model.Question;
import id.ac.dharmaiswara.app.model.Survey;
import id.ac.dharmaiswara.app.model.User;
import id.ac.dharmaiswara.app.utils.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, May 2017
 */
public class RESTService implements RestModel {

    private static final String USER_SESSION_ID = "user";
    private static final Logger logger = Logger.getLogger(RESTService.class.getSimpleName());

    public Sql2o mysql = null;
    private UuidGenerator uuidGenerator;

    public RESTService(Sql2o mysql) {
        this.mysql = mysql;
        this.uuidGenerator = new RandomUuidGenerator();
    }

    @Override
    public SurveyResponse mApiRegister(String user_nim, String user_name, String user_email) {
        String sql = "INSERT INTO user (user_id, user_nim, user_name, user_email) " +
                "VALUES (:user_id, :user_nim, :user_name, :user_email)";
        UUID user_id = uuidGenerator.generate();
        try (Connection con = mysql.open()) {
            con.createQuery(sql)
                    .addParameter("user_id", user_id.toString())
                    .addParameter("user_nim", user_nim)
                    .addParameter("user_name", user_name)
                    .addParameter("user_email", user_email)
                    .executeUpdate();
            User user = new User(user_id, user_nim, user_name, user_email);
            return new SurveyResponse(Api.Status.created, Api.Message.created, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SurveyResponse(Api.Status.error, Api.Message.error);
    }

    /**
     * Login mahasiswa
     *
     * @param nim of mahasiswa
     * @return mahasiswa detail
     */
    public SurveyResponse mApiLogin(String nim) {
        User user = getUserByNim(nim);
        if (user != null) {
            return new SurveyResponse(Api.Status.accepted, Api.Message.accepted, getUserByNim(nim));
        } else {
            return new SurveyResponse(Api.Status.notfound, Api.Message.notfound, null);
        }
    }

    @Override
    public User getUserByNim(String nim) {
        try (Connection connection = mysql.open()) {
            String query = "SELECT * FROM user WHERE user_nim = :user_nim";
            return connection.createQuery(query).throwOnMappingFailure(false).addParameter("user_nim", nim)
                    .executeAndFetchFirst(User.class);
        }
    }

    /**
     * Show all survey list
     *
     * @return list all survey
     */
    public SurveyResponse mApiSurveyList() {
        String sql = "SELECT * FROM survey";
        try (Connection con = mysql.open()) {
            return new SurveyResponse(200, Msg.OK(), con.createQuery(sql).executeAndFetch(Survey.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SurveyResponse(404, Msg.NotFound(), null);
    }

    /**
     * Show survey detail by survey_id
     *
     * @param survey_id of survey
     * @return survey detail by survey_id
     */
    public SurveyResponse mApiSurvey(String survey_id) {
        String sql = "SELECT * FROM survey WHERE survey_id=:survey_id";
        try (Connection con = mysql.open()) {
            return new SurveyResponse(200, Msg.OK(), con.createQuery(sql).addParameter("survey_id", survey_id)
                    .executeAndFetchFirst(Survey.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SurveyResponse(404, Msg.NotFound(), null);
    }

    /**
     * Show question by survey id
     *
     * @param survey_id of survey
     * @return question by survey_id
     */
    public SurveyResponse mApiQuestion(String survey_id) {
        String sql = "SELECT * FROM question WHERE survey_id=:survey_id";
        try (Connection con = mysql.open()) {
            return new SurveyResponse(200, Msg.OK(), con.createQuery(sql).addParameter("survey_id", survey_id)
                    .executeAndFetchFirst(Question.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SurveyResponse(404, Msg.NotFound(), null);
    }

    /**
     * Show question by survey id and question id
     *
     * @param survey_id   of survey
     * @param question_id of question
     * @return detail question
     */
    public SurveyResponse mApiQuestion(String survey_id, String question_id) {
        String sql = "SELECT * FROM question WHERE survey_id=:survey_id AND question_id=:question_id";
        try (Connection con = mysql.open()) {
            return new SurveyResponse(200, Msg.OK(), con.createQuery(sql).addParameter("survey_id", survey_id)
                    .addParameter("question_id", question_id)
                    .executeAndFetchFirst(Question.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SurveyResponse(404, Msg.NotFound(), null);
    }

    public SurveyResponse mApiChoice(String question_id) {
        String sql = "SELECT * FROM choice WHERE question_id=:question_id";
        try (Connection con = mysql.open()) {
            return new SurveyResponse(200, Msg.OK(), con.createQuery(sql).addParameter("question_id", question_id)
                    .executeAndFetch(Choice.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SurveyResponse(200, Msg.NotFound(), null);
    }


//    public SurveyResponse mApiQuestions() {
//        String sql0 = "SELECT * FROM question";
//        String sql1 = "SELECT * FROM choice";
//        try(Connection con = mysql.open()) {
//            int type = con.createQuery(sql0).executeAndFetchFirst(Question.class).getQuestion_type();
//            if (type==1 || type==2)
//                con.createQuery(sql1).executeAndFetch(Choice.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new SurveyResponse(404, Msg.NotFound(), null);
//    }
//
//    public SurveyResponse mApiQuestion(String survey_id) {
////        String sql = "SELECT * FROM question INNER JOIN choice ON question.question_id = choice.question_id " +
////                "WHERE question.question_id=:question_id";
//            String sql = "SELECT * FROM question WHERE survey_id = :survey_id";
//        try(Connection con = mysql.open()) {
//            return new SurveyResponse(200, Msg.OK(), con.createQuery(sql).addParameter("survey_id", survey_id)
//                    .executeAndFetch(Question.class));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new SurveyResponse(404, Msg.NotFound(), null);
//    }
//
//    public SurveyResponse mApiQuestionByQuestioinId(String qQuestion_id, String cQuestin_id) {
////        String sql = "SELECT * FROM question INNER JOIN choice ON question.question_id = choice.question_id " +
////                "WHERE question.question_id=:question_id";
//        String sql0 = "SELECT * FROM question WHERE question_id = :question_id";
//        String sql1 = "SELECT * FROM choice WHERE question_id = :question_id";
//        try(Connection con = mysql.open()) {
//            Question question = con.createQuery(sql0).addParameter("question_id", qQuestion_id)
//                    .executeAndFetchFirst(Question.class);
//            List<Choice> choice = con.createQuery(sql1).addParameter("question_id", cQuestin_id)
//                    .executeAndFetch(Choice.class);
//            question = new Question(question, choice);
//            return new SurveyResponse(200, Msg.OK(), question);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new SurveyResponse(404, Msg.NotFound(), null);
//    }
}
