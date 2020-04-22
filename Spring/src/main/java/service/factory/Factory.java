package service.factory;

import service.factory.BeanFactory;

/**
 * @author WangYao
 * @date 2020/4/16
 * @function
 */
@SuppressWarnings("all")
public class Factory {

    public BeanFactory getBeanFactory(){
        return new BeanFactory();
    }

    public static BeanFactory getBeanFactoryStatic(){
        return new BeanFactory();
    }
}
