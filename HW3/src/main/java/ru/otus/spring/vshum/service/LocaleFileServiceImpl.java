package ru.otus.spring.vshum.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.vshum.configs.LocaleConfig;
import ru.otus.spring.vshum.constant.FileConstant;
import ru.otus.spring.vshum.service.interfaces.LocaleFileService;

@Service
public class LocaleFileServiceImpl implements LocaleFileService {

    private final LocaleConfig localeConfig;

    public LocaleFileServiceImpl(LocaleConfig localeConfig) {
        this.localeConfig = localeConfig;
    }

    @Override
    public String getFilePathWithLocale(String filePath) {
        String [] pathArr = filePath.split(FileConstant.DOT_FOR_REGEXP);

        return pathArr[FileConstant.FILE_NAME]
                + localeConfig.getLocale().getLanguage()
                + FileConstant.DOT
                + pathArr[FileConstant.FILE_EXTENSION];
    }
}
