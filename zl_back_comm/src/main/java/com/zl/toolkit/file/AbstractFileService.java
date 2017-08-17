package com.zl.toolkit.file;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hlw on 2017/8/3.
 */
public abstract class AbstractFileService implements BaseFileService {

    @Override
    public <T>List<T> getData(File file) {
        return null;
    }

    @Override
    public <T>List<T> getData(String filePath) throws IOException {
        return null;
    }
}
