package thkoeln.archilab.st2.a1.LegalClause.application;

import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a1.LegalClause.domain.LegalClauseRepository;

@Service
public class LegalClauseService {
    private final LegalClauseRepository legalClauseRepository;

    public LegalClauseService (
            LegalClauseRepository legalClauseRepository
    ){
        this.legalClauseRepository = legalClauseRepository;
    }
}
