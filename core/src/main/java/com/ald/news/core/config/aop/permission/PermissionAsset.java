package com.ald.news.core.config.aop.permission;


/**
 * ,___         .-;'
 * `"-.`\_...._/`.`
 * ,       \        /
 * .-' ',      / ()   ()\
 * `'._ \     /()    .  (|
 * > .'  ;,     -'-  /
 * / <   |;,     __.;
 * '-.'-.|  , \    , \
 * `>.|;, \_)    \_)
 * `-;     ,    /
 * \    /   <
 * '. <`'-, _)
 * '._)
 *
 * @Author luohao
 * @Version 1.0.0
 * @Date 17:23 2017/12/8
 * @Desription 权限资源校验
 * @CopyRight 本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PermissionAsset {

}
