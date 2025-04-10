package diyor.adawev.clickup.service;

import diyor.adawev.clickup.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
}
