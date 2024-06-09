package com.danilohgds.mvcprojectmanager.enums;

import java.util.Arrays;
import java.util.function.Predicate;

public enum StatusProjeto {
    ANALISE_APROVADA {
        @Override
        public boolean podeExcluir() {
            return true;
        }
    },
    ANALISE_REALIZADA {
        @Override
        public boolean podeExcluir() {
            return true;
        }
    },
    CANCELADO {
        @Override
        public boolean podeExcluir() {
            return true;
        }
    },
    EM_ANALISE {
        @Override
        public boolean podeExcluir() {
            return true;
        }
    },
    EM_ANDAMENTO {
        @Override
        public boolean podeExcluir() {
            return false;
        }
    },
    ENCERRADO {
        @Override
        public boolean podeExcluir() {
            return false;
        }
    },
    INICIADO {
        @Override
        public boolean podeExcluir() {
            return false;
        }
    },
    PLANEJADO {
        @Override
        public boolean podeExcluir() {
            return true;
        }
    };

    @SuppressWarnings("unused")
    public abstract boolean podeExcluir();

    StatusProjeto getEnum(String nomeStatus){
        // Handling NON-ASCII characters in Enum values
        if(nomeStatus.equalsIgnoreCase("em análise")) {
            return EM_ANALISE;
        }
        if(nomeStatus.equalsIgnoreCase("análise realizada")) {
            return ANALISE_REALIZADA;
        }
        if(nomeStatus.equalsIgnoreCase("análise aprovada")) {
            return ANALISE_APROVADA;
        }
        return StatusProjeto.valueOf(nomeStatus.toUpperCase().trim());
    }
}
