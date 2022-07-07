package com.lyd.management.service.impl;

import com.lyd.management.dao.RepositoryMapper;
import com.lyd.management.model.RmRepository;
import com.lyd.management.service.RmRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepoServiceImpl implements RmRepositoryService {
    @Autowired
    RepositoryMapper repositoryMapper;

    @Override
    public List<RmRepository> getRepositoryList() {
        List<RmRepository> repoList = repositoryMapper.findRepoList();
        return repoList;
    }

    @Override
    public RmRepository selectRepoByIdService(int id) {
        return repositoryMapper.selectRepoById(id);
    }

    @Override
    public Boolean removerRepositoryService(int id) {
        boolean result = repositoryMapper.deleteRepoById(id);
        return result;
    }

    @Override
    public boolean addRepositoryService(RmRepository rmRepository) {
        boolean result = repositoryMapper.saveRepo(rmRepository);
        return result;
    }

    @Override
    public boolean editRepositoryService(RmRepository rmRepository) {
        boolean result = repositoryMapper.updateRepo(rmRepository);
        return result;
    }
}
