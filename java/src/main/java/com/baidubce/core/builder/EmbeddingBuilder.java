/*
 * Copyright (c) 2024 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidubce.core.builder;

import com.baidubce.core.Qianfan;
import com.baidubce.model.constant.ModelEndpoint;
import com.baidubce.model.embedding.EmbeddingRequest;
import com.baidubce.model.embedding.EmbeddingResponse;

import java.util.List;

public class EmbeddingBuilder extends BaseBuilder<EmbeddingBuilder> {
    private List<String> input;

    public EmbeddingBuilder() {
        super();
    }

    public EmbeddingBuilder(Qianfan qianfan) {
        super(qianfan);
    }

    public EmbeddingBuilder input(List<String> input) {
        this.input = input;
        return this;
    }

    public EmbeddingRequest build() {
        String finalEndpoint = ModelEndpoint.getEndpoint(ModelEndpoint.EMBEDDINGS, super.getModel(), super.getEndpoint());
        return new EmbeddingRequest()
                .setEndpoint(finalEndpoint)
                .setInput(input)
                .setUserId(super.getUserId())
                .setExtraParameters(super.getExtraParameters());
    }

    public EmbeddingResponse execute() {
        return super.getQianfan().embedding(build());
    }
}
