/*
Copyright 2022 RethinkDNS and its authors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.celzero.bravedns.database

import androidx.room.Transaction
import com.celzero.bravedns.automaton.RethinkBlocklistManager


class RethinkLocalFileTagRepository(private val rethinkLocalFileTagDao: RethinkLocalFileTagDao) {

    @Transaction
    suspend fun update(fileTag: RethinkLocalFileTag) {
        rethinkLocalFileTagDao.update(fileTag)
    }

    suspend fun insertAsync(fileTag: RethinkLocalFileTag) {
        rethinkLocalFileTagDao.insert(fileTag)
    }

    suspend fun insertWithReplace(fileTag: RethinkLocalFileTag) {
        rethinkLocalFileTagDao.insertReplace(fileTag)
    }

    suspend fun insertAll(fileTags: List<RethinkLocalFileTag>): LongArray {
        return rethinkLocalFileTagDao.insertAll(fileTags)
    }

    suspend fun updateSelectedTags(list: Set<Int>, isSelected: Int) {
        rethinkLocalFileTagDao.updateSelectedTags(list, isSelected)
    }

    suspend fun getSimpleViewTags(): List<RethinkBlocklistManager.SimpleViewMapping> {
        return rethinkLocalFileTagDao.getSimpleViewTags()
    }

    suspend fun clearSelectedTags() {
        return rethinkLocalFileTagDao.clearSelectedTags()
    }
}
