/*
   Example java code for the deepmesa project.

   Copyright 2021 "Rahul Singh <rsingh@arrsingh.com>"

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.deepmesa.examples;

import java.util.Map;
import java.util.HashMap;

/*
    An example data structure that indexes the key, value pair by both
    the key and the value.

    For more see: http://deepmesa.com/blog/rust-storing-data-in-multiple-containers
*/
public class DualIndexMap<K,V> {
    private Map<K, V> kvMap;
    private Map<V, K> vkMap;

    public DualIndexMap() {
        this.kvMap = new HashMap<K, V>();
        this.vkMap = new HashMap<V,K>();
    }

    public void put(K key, V val) {
        this.kvMap.put(key, val);
        this.vkMap.put(val, key);
    }

    public V getByKey(K key) {
        return this.kvMap.get(key);
    }

    public K getByVal(V val) {
        return this.vkMap.get(val);
    }

    public static void main(String[] args) {
        DualIndexMap<Integer, Long> dualIndexMap = new DualIndexMap<Integer, Long>();
        dualIndexMap.put(100, Long.valueOf(1000));
        assert dualIndexMap.getByKey(100) == 1000;
        assert dualIndexMap.getByVal(Long.valueOf(1000)) == 100;
        assert dualIndexMap.getByKey(1000) == null;
    }
}
