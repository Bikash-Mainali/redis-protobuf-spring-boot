//package com.ecrr.fct.serializer.pdx;
//
//import org.apache.geode.cache.Cache;
//import org.apache.geode.cache.CacheFactory;
//
///**
// * @PROJECT IntelliJ IDEA
// * @AUTHOR Bikash Mainali
// * @DATE 1/22/24
// */
//public class GemfireConfig {
//
//    public static Cache configGemfireCache() {
//        Cache gemfireCache = new CacheFactory()
//                .setPdxPersistent(true) // Enable PDX serialization
//                .setPdxReadSerialized(true) // Enable reading of serialized PDX data
//                .create();
//
//        return gemfireCache;
//    }
//}
