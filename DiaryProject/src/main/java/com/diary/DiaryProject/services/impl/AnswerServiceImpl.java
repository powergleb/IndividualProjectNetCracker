package com.diary.DiaryProject.services.impl;

        import com.diary.DiaryProject.dao.repositories.AnswerRepository;
        import com.diary.DiaryProject.dao.repositories.GroupRepository;
        import com.diary.DiaryProject.dao.repositories.StudentRepository;
        import com.diary.DiaryProject.entities.Answer;
        import com.diary.DiaryProject.entities.Group;
        import com.diary.DiaryProject.entities.Homework;
        import com.diary.DiaryProject.services.AnswerService;
        import com.diary.DiaryProject.services.GroupService;
        import lombok.NoArgsConstructor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

@Service("answerServiceImpl")
@NoArgsConstructor
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    public AnswerRepository answerRepository;
    @Autowired
    public FileServiceImpl fileService;

    @Override
    public Answer createAnswer(Answer answer) {
        Answer answer1 = answerRepository.save(answer);
        fileService.updateFile(answer);
        return answer1;
    }

    @Override
    public Answer readAnswer(int id) {
        return answerRepository.getById(id);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }

    @Override
    public List<Answer> readAllAnswer() {
        return answerRepository.findAll();
    }
}
